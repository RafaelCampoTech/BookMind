(ns bookmind.utils
  (:require  [cheshire.core :refer [parse-string]]))

(defn encode-url [s]
  (-> (java.net.URLEncoder/encode s "UTF-8")
      (.replace "+" "%20")))


(defn parse-body-params
  [request]
  (update request :body #(parse-string % true)))
 