(ns bookmind.services.internet-archive.model
  (:require [org.httpkit.client :as http]
            [bookmind.utils]))


(defonce base-url "https://archive.org/advancedsearch.php")


(defn search-archive [query]
  (let [search-params (-> (str "?q=" query "&fl[]=identifier,title,description&rows=10&page=1&output=json")
                          bookmind.utils/encode-url)
        url  (str base-url search-params)]
    (-> @(http/get url)
        (select-keys [:status :body :headers]))))



(defn search-archive
  "Searches the Internet Archive for a given query and returns the results as a map containing the status, body, and headers of the response."
  [query & {:keys [rows page]}]
  (let [url (str base-url)
        options {:query-params {"q" query
                                "fl[]" ["identifier" "title" "description"]
                                "rows" (or rows 10)
                                "page" (or page 1)
                                "output" "json"}}]
    (-> @(http/get url options)
        (select-keys [:status :body :headers]))))

(defn get-book
  [{{body :body} :parameters}]
  {:status 200
   :body body})


(comment
  (search-archive "quantum computing"))

