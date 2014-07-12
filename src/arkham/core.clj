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
  (find-locations game #(has-flag? % :clue)))

(defn- location [game id]
  (first (find-locations game #(= (:id %) id))))

(defn- location-index [game id]
  {:post [(integer? %)]}
  (first (keep-indexed #(when (= id (:id %2)) %1) (locations game))))

(defn- update-location [game id fun & args]
  (apply update-in game [:board :arkham :locations (location-index game id)] fun args))

(defn- update-locations [game fun location-ids]
  (reduce (fn [game' id]
            (update-location game' id fun))
          game
          location-ids))

(defn- inc-clue-tokens [game location-ids]
  (update-locations game
                    #(update-in % [:clue-tokens] (fn [i]
                                                   (inc (or i 0))))
                    location-ids))

(defn- place-clue-tokens [game]
  (inc-clue-tokens game
                   (map :id (find-locations-by-flag game :clue))))

(defn new-game [board-template]
  (-> {:players []
       :terror 0}
      (assoc :board board-template)
      (place-clue-tokens)))

(defn foo [] (prn (new-game data/board)))

(def game {:players [{:id 1
                      :name "Foo"
                      :sheet :amanda-sharpe
                      :sanity 5
                      :stamina 5
                      :location "???"
                      :clue-tokens 0
                      :money 0}]
           :terror 0})