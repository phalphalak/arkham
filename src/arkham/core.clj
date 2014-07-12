(ns arkham.core
  (:require [arkham.data :as data]))

(def board-gui-data
  {})

(defn- locations [game]
  (get-in game [:board :arkham :locations]))

(defn- find-locations [game predicate]
  (filter predicate
          (locations game)))

(defn- has-flag? [location flag]
  (some (partial = flag) (location :flags)))

(defn- find-locations-by-flag [game flag]
  (find-locations game #(has-flag? (second %) flag)))

(defn- location [game id]
  ((locations game) :id))

(defn- update-location [game id fun & args]
  (apply update-in game [:board :arkham :locations id] fun args))

(defn- update-locations [game fun location-ids]
  (reduce (fn [game' id]
            (update-location game' id fun))
          game
          location-ids))

(defn- inc-clue-tokens [game location-ids]
  (update-locations game
                    #(update-in %
                                [:clues]
                                (fn [i]
                                  (inc (or i 0))))
                    location-ids))

(defn- place-clue-tokens [game]
  (inc-clue-tokens game
                   (map first (find-locations-by-flag game :unstable))))

(defn- init-monsters [game]
  (assoc game
    :monsters
    (vec (reduce (fn [acc [id n]]
                   (concat acc
                           (repeat n {:type id
                                      :location nil})))
                 []
                 {:vampire 4}))))

(defn new-game [templates]
  (-> {:players []
       :monsters []
       :terror 0}
      (assoc :templates templates)
      (assoc :board (:board templates))
      (place-clue-tokens)
      (init-monsters)))

(defn foo []
  (data/init-game-data!)
  (new-game @data/data))

(def game {:players [{:id 1
                      :name "Foo"
                      :sheet :amanda-sharpe
                      :sanity 5
                      :stamina 5
                      :location "???"
                      :clue-tokens 0
                      :money 0}]
           :terror 0})