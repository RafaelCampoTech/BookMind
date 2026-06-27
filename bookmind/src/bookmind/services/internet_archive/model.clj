(ns bookmind.services.internet-archive.model
  (:require [environ.core :refer [env]]
            [ring.util.http-response :as resp]))


(defn get-book
  [{{body :body} :parameters}]
  {:status 200
   :body body})