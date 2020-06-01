(ns ^:figwheel-hooks com.example.hello-world-cljs
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]))

(defn multiply [a b] (* a b))

(def make-shirt vector)
(def get-neck-size first)
(def get-length second)

(def my-favorite-shirt (make-shirt "16" "35-36"))
(def my-second-favorite-shirt  (make-shirt "16" "33-34"))
(def my-shirts [my-favorite-shirt my-second-favorite-shirt])

(defn information-table-row [shirt]
  [:tr
   [:td ">"]
   [:td (get-neck-size shirt)]
   [:td (get-length shirt)]])

(defn information-table [my-shirts]
  [:table
   (map information-table-row my-shirts)])

(defn shirt-website []
  [:div
   [:div
    [:h1 "Shirt List"]]
   [:div
    [information-table my-shirts]]])

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [el]
  (reagent/render-component [shirt-website] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
