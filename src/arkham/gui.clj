(ns arkham.gui
  (:import [javax.swing JFrame JPanel]
           [java.awt Dimension]))

(defn- make-board-panel [game-state]
  (doto (proxy [JPanel] []
          (paintComponent [g]
            (proxy-super paintComponent g)
            (when @game-state
              (prn 1)
              (prn 2))
            ))

    (.setPreferredSize (new Dimension 600 900))))

(defn show-gui [game-state]
  (doto (new JFrame "Arkahm")
    (doto (.getContentPane)
      (.add (make-board-panel game-state)))
    (.pack)
    (.show)))