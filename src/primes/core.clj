(ns primes.core
  (:gen-class))

(defn- next-prime [i primes] ; i cannot be 1
  (if (empty? primes)
    2
    (if (not-any? #(= 0 (mod i %)) primes)
      i
      (next-prime (+ 1 i) primes))))

(defn- first-n-primes-foo
  [n primes]
  (if (= n (count primes))
    primes
    (let [nextp (next-prime (last primes) primes)]
      (first-n-primes-foo nextp (conj primes nextp primes)))))

(defn first-n-primes
 "returns the first n primes"
 [n]
 (first-n-primes-foo 2 []))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
