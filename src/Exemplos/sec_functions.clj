(ns Exemplos.sec-functions)

;---
; Map -> vampiro diminuindo consumo de humanos e mesclando com outras criaturas
(def human-consumption [8.1 7.3 6.6 5.5])
(def critter-consumption [0.0 0.2 0.3 1.1])
(defn unify-diet-data
  [human critter]
  {:human human
   :critter critter})

(map unify-diet-data human-consumption critter-consumption)
;=> ({:human 8.1, :critter 0.0} {:human 7.3, :critter 0.2} {:human 6.6, :critter 0.3} {:human 5.5, :critter 1.1})

;---
; Map -> calculos em conjuntos diferentes de numeros

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(stats [3 4 10])
;=> (17 3 17/3)

(stats [80 1 44 13 6])
;=> (144 5 144/5)

;---
; Map -> recuperar valores associados a uma Keyword de uma estrutura de maps
(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spider-Man" :real "Peter Parker"}
   {:alias "Santa" :real "Your Mom"}
   {:alias "Easter Bunny" :real "Your dad"}])

(map :real identities)
;=> ("Bruce Wayne" "Peter Parker" "Your Mom" "Your dad")

;---