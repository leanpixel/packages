# cljsjs/react

```clojure
[cljsjs/sugar "1.4.1-0"] ;; latest release
```

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
