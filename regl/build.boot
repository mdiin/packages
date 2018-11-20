(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.9")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/regl
      :version     +version+
      :description "Fast functional WebGL"
      :url         "http://regl.party/"
      :scm         {:url "https://github.com/regl-project/regl"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      "https://npmcdn.com/regl@1.3.9/dist/regl.js")
   (download  :url      "https://npmcdn.com/regl@1.3.9/dist/regl.min.js")
   (sift      :move     {#"^regl.js"
                         "cljsjs/regl/development/regl.inc.js"
                         #"^regl.min.js"
                         "cljsjs/regl/production/regl.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.regl")
   (pom)
   (jar)
   (validate-checksums)))
