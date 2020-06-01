(ns com.example.hello-world-cljs-test
    (:require
     [cljs.test :refer-macros [deftest is testing]]
     [com.example.hello-world-cljs :refer [multiply]]))

(deftest multiply-test
  (is (= (* 1 2) (multiply 1 2))))

(deftest multiply-test-2
  (is (= (* 75 10) (multiply 10 75))))
