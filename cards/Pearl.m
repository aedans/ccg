(def name "Pearl")
(def text "Grants [Pearl].")
(def type (starting artifact))
(def cost (list (mana 1)))
(def cast cast-permanent)
(def enters-field '(add-gem caster pearl 1))
(def leaves-field '(add-gem caster pearl -1))
