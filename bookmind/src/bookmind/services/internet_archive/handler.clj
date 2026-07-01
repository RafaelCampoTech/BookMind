(ns bookmind.services.internet-archive.handler
  (:require [bookmind.services.internet-archive.model :as model]))


(defn get-book-handler
  [{{body :body} :parameters}]
  (model/search-book-by-title body))
 