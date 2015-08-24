(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.4.1-1")
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
    (download :url "https://raw.githubusercontent.com/andrewplummer/Sugar/45eed3e4e5c6dd8adfbff3e652c5dc1b1e67dbd5/release/sugar-full.dev.js"
              :checksum "9B9529F9B4E319F17F55831BE4C30711")
    (download :url "https://raw.githubusercontent.com/andrewplummer/Sugar/45eed3e4e5c6dd8adfbff3e652c5dc1b1e67dbd5/release/sugar-full.min.js"
              :checksum "ECF92C9C40B1830010CA7F64D277B011")
    (sift :move {#"sugar-full.dev.js" "cljsjs/development/sugar.inc.js"
                 #"sugar-full.min.js" "cljsjs/production/sugar.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.sugar")))
