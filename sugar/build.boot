(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.4.1-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'org.clojars.leanpixel/sugar
       :version     +version+
       :description "Sugar.js packaged up with Google Closure externs"
       :url         "http://sugarjs.com/"
       :scm         {:url "https://github.com/andrewplummer/Sugar"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://raw.githubusercontent.com/andrewplummer/Sugar/master/release/sugar-full.dev.js"
              :checksum "6bda462db1b7d5f9e0923d0893ef0a40")
    (download :url "https://raw.githubusercontent.com/andrewplummer/Sugar/master/release/sugar-full.min.js"
              :checksum "a4e14377c3d5de8aa3d1b0eb5cf454b4")
    (sift :move {#"sugar-full.dev.js" "cljsjs/development/sugar.inc.js"
                 #"sugar-full.min.js" "cljsjs/production/sugar.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "org.clojars.leanpixel/sugar")))
