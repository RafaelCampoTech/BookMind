(ns bookmind.core
  (:gen-class)
  (:require
   [org.httpkit.server :as http]
   [bookmind.routes :refer [app]])) 

(defonce server (atom nil))

(defn stop-server []
  (when-let [stop-fn @server]
    (stop-fn :timeout 100)
    (reset! server nil)))

(defn -main [& _]
  (reset! server
          (http/run-server #'app {:port 8080}))
  (println "Listening on http://localhost:8080/docs"))


