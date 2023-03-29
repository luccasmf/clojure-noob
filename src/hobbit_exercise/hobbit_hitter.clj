(ns hobbit-exercise.hobbit-hitter)

;criando um vector de maps com :name e :size, representando um hobbit
(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])


;função que vai transformar cada uma das partes na sua correspondente do outro lado
(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})


;função responsável por operar essa criação de partes simétricas
(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts final-body-parts []]
    (if (empty? remaining-asym-parts)                       ;se remaining-asym-parts já nao tiver nada, retorna a lista final
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]        ;divide a lista em uma head (part) que será processada, e uma tail (remaining) que entrará na recursividade
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)]))))))) ;refaz o loop com um novo valor de "remaining-asym-parts" e um novo valor de "final-body-parts

;versão melhorada do symmetrizzer
(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
             (into final-body-parts (set [part (matching-part part)]))) ;função que vai adicionar um "set" ao meu valor inicial passado, recursivamente
           []                                               ;valor opcional INICIAL, um Vector vazio
           asym-body-parts))                                ;coleção referência para a recursividade

;função que acerta o hit em algum lugar aleatorio
(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts accumulated-size (:size part)]
      (if (> accumulated-size target)
      part
      (recur remaining (+ accumulated-size (:size (first remaining))))))))
