@echo off
java -cp ../lib/cup_v10k.jar java_cup.Main -destdir rs\ac\bg\etf\pp1 -dump_states -parser MJParser -ast rs.ac.bg.etf.pp1.ast -buildtree ..\spec\mjparser.cup
