(ns Exercises.First)



; Ex 2
(defn dec-maker
  [dec-by]
  #(- % dec-by))

(def dec9 (dec-maker 9))


; Ex 3
(defn inc100
  [number]
  (+ number 100))


; Ex 4
[(defn mapset_loop
  [operationName map]
  (loop [[head & tail] map final_set #{}]
    (if (empty? tail)
      final_set
      (recur tail
             (into final_set
                   (set [(operationName head)]))))))]

[(defn mapset_reduce
   [operationName map]
   (reduce (fn [final_set number]
             (into final_set (set [(operationName number)])))
           #{}
           map))]
