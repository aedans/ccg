(def name "Infused Ruby")
(def text "Grants [Ruby].")
(def type (starting artifact))
(def cost (list (life 3)))
(def cast cast-permanent)
(def enters-field '(add-gem caster ruby 1))
(def leaves-field '(add-gem caster ruby -1))
