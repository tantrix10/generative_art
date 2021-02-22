(
  ns quil-site.example.leaf
   (
    :require [quil.core :as q :include-macros true]))
   
 


  
(defn paint-blotch-update [state]
 (
      ( conj state
      {
       :x   (* 100 (-  (q/sin (* (:x (last state)) (:y (last state)) ))  (q/cos (+ (:x ( last state)) (:y (last state))))))
       :y   (* 100 (- (q/cos (* (:x (last state)) (:y (last state)) )) (q/sin (+ (:x (last state)) (:y (last state))))))
       }

       )
   ))
             
      
   
  

(defn paint-blotch-draw [state]
  (q/stroke-weight 25)
  (print state)
  (doseq [{x1 :x y1 :y} state]
    (q/point x1 y1)))

(defn paint-blotch-setup []
  (q/background 255)
  (q/fill 0)
  (list 
    {
     :x 1
     :y 1
   }
   )
  )

(q/defsketch dots
  :host "paint-blotch"
  :size [300 300]
  :setup #'paint-blotch-setup
  :update #'paint-blotch-update
  :draw #'paint-blotch-draw)

