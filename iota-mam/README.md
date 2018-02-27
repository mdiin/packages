# cljsjs/iota

[](dependency)
```clojure
[cljsjs/iota-mam "0.0.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.iota-mam))
```
or
```clojure
(ns application.core
  (:require cljsjs.iota-mam-light))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps