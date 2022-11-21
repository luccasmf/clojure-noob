(ns clojure-noob.core
  (:gen-class)
  (:require
    [hobbit-exercise.hobbit-hitter :refer :all] ))


(defn hit-the-hobbit
  "Hits the hobbit"
  []
  (hit asym-hobbit-body-parts))

(defn -main
  "run the created exercises"
  [& args]
  (do
    (println (hit-the-hobbit))
    (println (hit-the-hobbit))
    ))



