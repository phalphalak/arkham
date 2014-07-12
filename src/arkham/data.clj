(ns arkham.data
  (:require [clojure.edn :as edn]
            [arkham.util :as util]))

(defn load
  ([file]
     (edn/read-string (slurp file)))
  ([file & files]
     (util/deep-merge (load file)
                      (apply load files))))

(def data (atom nil))

(defn init-game-data! []
  (reset! data (load "resources/sheets.edn"
                     "resources/monsters.edn"
                     "resources/board.edn")))

(def cards [{:type :common-item}
            {:type :unique-item}
            {:type :skill}
            {:type :spell}
            {:type :ally}
            {:type :special}
            {:type :ancient-one-location}
            {:type :ancient-one-gate}
            {:type :ancient-one-mythos}])
