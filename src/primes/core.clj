(ns primes.core
  (:gen-class))

(defn next-prime [i primes] ; i cannot be 1
  (if (empty? primes)
    2
    (if (not-any? #(= 0 (mod i %)) primes)
      i
      (next-prime (+ 1 i) primes))))

(defn first-n-primes
  "returns the first n primes"
  ([n]
    (first-n-primes n []))
  ([n primes] ; private recursive helper
    (if (= n (count primes))
      primes
      (let [nextp (next-prime (last primes) primes)]
        (first-n-primes n (conj primes nextp))))))

(defn -main
  [& args]
  (println (first-n-primes (read-string (first args)))))
