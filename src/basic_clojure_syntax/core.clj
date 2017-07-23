(ns basic-clojure-syntax.core)                              ;;namespace

                                                            ;;comment

;;VALUES
1                                                           ;;number
1.3                                                         ;;number, float
1/3                                                         ;;number, rational
"string"                                                    ;;string, like java
true                                                        ;;boolean
false
nil                                                         ;;similar to null in java, also false

;;variables
(def a 1)                                                   ;;def defines a value

;;CONTROL STRUCTURES

(cond
  (= x 100) println "x=100"
  (> x 100) println "x>100"
  :else print "x<100"
  )

(if (= x 100) println "x=100" println "not x=100")

(do                                                         ;;You can do various line that evaluates to a single
  (println "task one")                                      ;;expression, the last one is returned
  (println "task two"))


(dotimes [i n] (expr))                                      ;;repeat n times the expr, i contains the current iteration
(dotimes [i 10] (println i))                                ;;repeat 10 times println : 0 1 2 3 4 5 6 7 8 9

;;FUNCTIONS

(defn foo                                                   ;;defn defines a function
  "I don't do a whole lot."                                 ;;you can document the function
  [x]                                                       ;;args
  (println x "Hello, World!"))                              ;;body

(foo 1)                                                     ;;parens evals expr


(def foo2 (fn [x]                                           ;;same as defn but with anonymous fn
  (println x "Hello, World!")) )

(foo2 2)

(defn even? [number]                                        ;;functions that returns boolean values
  (= (mod number 2) 0))                                     ;;usually are name with question mark at
                                                            ;;the end. This type of fn are "predicates"(reduce
;;HELP

(doc nth)                                                   ;;to know the documentation of the fn

;;DATA STRUCTURES

;;VECTORS

[1 2 3 4]

;; You can direct access it's values
(first [1 2 3 4])                                           ;; 1
(last [1 2 3 4])                                            ;; 4
(nth [1 2 3 4] 0)                                           ;; 1
(nth [1 2 3 4] 3)                                           ;; 4

;;DICTIONARIES

{1 "a" 2 "b" 3 "c"}                                         ;;{1 "a", 2 "b", 3 "c"} 1 is the key to "a"

(def d {1 "a" 2 "b" 3 "c"} )

(get d 1)                                                   ;;access by key, returns "a"

;;SETS

#{1 2 3 4 5}

#{1 1 3 4 5}                                                ;;Sets cannot have duplicates, this throws an error

;;VARIADIC FUNCTION DEFINITIONS

(defn my-function                                           ;;you can declare multiple function bodies
  ([] "zero args" )                                         ;;changing the number of args
  ([a] "one arg" )
  ([a b] "two args" )
  )

(defn print-numbers                                         ;;example of variadic function
  ([up-to]
    (dotimes [i up-to] (println (+ i 1)) ))
  ([]
    (print-numbers 1))
  )

;;FUNCTIONS IN STD LIB

;;map applies fn to every item on the collection and returns the result
(map count ["cat" "dog" "horse"])                           ;;(3 3 5)
(map inc [1 2 3])                                           ;;(2 3 4)

;;filter reduces a collection to just the values that matches the filter function
(filter even? (range 1 10))                                 ;;(2 4 6 8)


(filter (fn [x]
          (not (zero?(mod x 3)) ))
        (range 1 10))                                       ;;(1 2 4 5 7 8)


;;reduce assemble something new applying fn to each element
(reduce fn start coll)                                      ;;fn needs two args, start is the start element (not index)

(reduce + 0 (range 1 10))                                   ;;0 because 0 is the identity for +
(reduce * 1 (range 1 10))                                   ;;1 because 1 is the identity for *


;;into adds a collection to another

(into #{} #{(range 10)})                                    ;;#{(0 1 2 3 4 5 6 7 8 9)}
(into ["a" "b"] (range 10))                                 ;;["a" "b" 0 1 2 3 4 5 6 7 8 9]

