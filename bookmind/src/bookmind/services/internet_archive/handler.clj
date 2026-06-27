(ns bookmind.services.internet-archive.handler
  (:require [bookmind.services.internet-archive.model :as model]
            [bookmind.utils.schemas :refer [User]]))


(def routes
   ["/archive"
    {:get {:summary "Get a file from internet archive"
           :description "Creates a user"
           :parameters {:body User}
           :responses {200 {:body User}}
           :handler model/get-book}}])
