@echo off
java -jar ../lib/cup_v10k.jar -destdir rs\ac\bg\etf\pp1 -dump_states -parser MJParser -ast rs.ac.bg.etf.pp1.ast -buildtree ..\spec\mjparser.cup
