(def name "Sanguimancer Adept")
(def text "When Sanguimancer Adept enters the battlefield or dies, you gain 3 life.")
(def type (starting creature))
(def cost (list (mana 1) (gem onyx 1)))
(def stats (pair 1 1))
(def cast cast-permanent)
(def enters-field '(add-life caster 3))
(def leaves-field '(add-life caster 3))
