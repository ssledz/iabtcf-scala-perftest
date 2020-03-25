## Profiling

```
sbt
jmh:run TCStringParserBench -f1 -wi 2 -i2 -prof jmh.extras.JFR:dir=/tmp/profile-jfr;flameGraphDir=/home/sledzs/git/FlameGraph;;jfrFlameGraphDir=/home/sledzs/bin/jfr-flame-graph/bin;flameGraphOpts=--minwidth,2;verbose=true
```