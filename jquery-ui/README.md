# cljsjs/jquery-ui

[](dependency)
```clojure
[cljsjs/jquery-ui "1.11.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.jquery-ui))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

