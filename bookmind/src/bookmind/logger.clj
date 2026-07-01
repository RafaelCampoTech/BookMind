(ns bookmind.logger)

(def ^:dynamic *log-ctx* {})
;;   ☝ allow override of the var

(defmacro with-log-context
  "given a map of key-value, execute the body with the log context
  augmented by the given context. At the end of the execution, the
  original context is restored."
  [ctx & body]
  `(with-bindings {#'*log-ctx* (merge *log-ctx* ~ctx)}
     (do ~@body)))