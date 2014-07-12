(ns arkham.data)

(def sheets [{:id :amanda-sharpe
              :name "Amanda Sharpe"
              :occupation "the Student"
              :max-sanity 5
              :max-stamina 5
              :home "???"
              :possessions {}
              :unique-ability "???"
              :focus 3
              :skill-pairs "???"}])

(def ancient-ones [])

(def cards [{:type :common-item}
            {:type :unique-item}
            {:type :skill}
            {:type :spell}
            {:type :ally}
            {:type :special}
            {:type :ancient-one-location}
            {:type :ancient-one-gate}
            {:type :ancient-one-mythos}])

(def monsters [{:id :vampire
                :name "Vampire"
                :awareness -3
                :movement-type :normal
                :home-dimension "???"
                :abilities [:undead
                            :physical-resistance]
                :description "???"
                :horror-rating 0
                :horror-damage 2
                :toughness 2
                :combat-damage 3
                :combat-rating -3}])

(def board {:arkham {:locations [{:id :uptown
                                  :name "Uptown"
                                  :flags [:street]
                                 :neighborhood 0}
                                 {:id :woods
                                  :name "Woods"
                                  :flags [:clue]
                                  :neighborhood 0}
                                {:id :ye-olde-magick-shoppe
                                 :name "Ye Olde Magick Shoppe"
                                 :neighborhood 0}
                                {:id :st-marys-hospital
                                 :name "St. Mary's Hospital"
                                 :neighborhood 0}
                                {:id :southside
                                 :name "Southside"
                                  :flags [:street]
                                 :neighborhood 1}
                                {:id :historical-society
                                 :name "Historical Society"
                                  :flags [:clue]
                                 :neighborhood 1}
                                {:id :south-church
                                 :name "South Church"
                                 :neighborhood 1}
                                {:id :mas-boarding-house
                                 :name "Ma's Boarding House"
                                 :neighborhood 1}
                                {:id :french-hill
                                 :name "French Hill"
                                  :flags [:street]
                                 :neighborhood 2}
                                {:id :silver-twilight-lodge
                                 :name "Silver Twilight Lodge"
                                 :flags [:clue]
                                 :neighborhood 2}
                                {:id :the-witch-house
                                 :name "The Witch House"
                                 :flags [:clue]
                                 :neighborhood 2}
                                {:id :miskatonic-university
                                 :name "Miskatonic University"
                                  :flags [:street]
                                 :neighborhood 3}
                                {:id :library
                                 :name "Library"
                                 :neighborhood 3}
                                {:id :administration
                                 :name "Administration"
                                 :neighborhood 3}
                                {:id :science-building
                                 :name "Science Building"
                                 :flags [:clue]
                                 :neighborhood 3}
                                {:id :merchant-district
                                 :name "Merchant District"
                                 :flags [:street]
                                 :neighborhood 4}
                                {:id :the-unnamable
                                 :name "The Unnamable"
                                 :flags [:clue]
                                 :neighborhood 4}
                                {:id :river-docks
                                 :name "River Docks"
                                 :neighborhood 4}
                                {:id :unvisted-isle
                                 :name "Unvisted Isle"
                                 :flags [:clue]
                                 :neighborhood 4}
                                {:id :rivertown
                                 :name "Rivertown"
                                  :flags [:street]
                                 :neighborhood 5}
                                {:id :general-store
                                 :name "General Store"
                                 :neighborhood 5}
                                {:id :black-cave
                                 :name "Black Cave"
                                 :flags [:clue]
                                 :neighborhood 5}
                                {:id :graveyard
                                 :name "Graveyard"
                                 :flags [:clue]
                                 :neighborhood 5}
                                {:id :easttown
                                 :name "Easttown"
                                  :flags [:street]
                                 :neighborhood 6}
                                {:id :police-station
                                 :name "Police Station"
                                 :neighborhood 6}
                                {:id :velmas-diner
                                 :name "Velma's Diner"
                                 :neighborhood 6}
                                {:id :hibbs-roadhouse
                                 :name "Hibb's Roadhouse"
                                 :flags [:clue]
                                 :neighborhood 6}
                                {:id :downtown
                                 :name "Downtown"
                                  :flags [:street]
                                 :neighborhood 7}
                                {:id :independence-square
                                 :name "Independence Square"
                                 :flags [:clue]
                                 :neighborhood 7}
                                {:id :arkham-asylum
                                 :name "Arkham Asylum"
                                 :neighborhood 7}
                                {:id :bank-of-arkham
                                 :name "Bank of Arkham"
                                 :neighborhood 7}
                                {:id :northside
                                 :name "Northside"
                                  :flags [:street]
                                 :neighborhood 8}
                                {:id :train-station
                                 :name "Train Station"
                                 :neighborhood 8}
                                {:id :newspaper
                                 :name "Newspaper"
                                 :neighborhood 8}
                                {:id :curiositie-shoppe
                                 :name "Curiositie Shoppe"
                                 :neighborhood 8}]
                    :connections [[:uptown :southside true]
                                  [:southside :french-hill true]
                                  [:miskatonic-university :uptown true]
                                  [:merchant-district :miskatonic-university true]
                                  [:french-hill :rivertown true]
                                  [:rivertown :easttown true]
                                  [:easttown :downtown true]
                                  [:downtown :northside true]
                                  [:northside :merchant-district true]
                                  [:miskatonic-university :french-hill false]
                                  [:merchant-district :rivertown false]
                                  [:downtown :merchant-district false]]}
            :other-worlds [{:id :another-dimension
                            :name "Another Dimension"
                            :colour [:red :blue :yellow :green]}]
            :city-limits [:outskirts :the-sky :lost-in-time-and-space]})