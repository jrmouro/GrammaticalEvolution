set title 'Test'
set xlabel 'time'
set ylabel 'volume'
set grid
set xrange [0:100]
set yrange [0:20]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = ((log((0.0 + x)) * 3.14159265359) - exp(-1.0))
plot f(x) title '((log((0.0 + x)) * 3.14159265359) - exp(-1.0))', '/home/ronaldo/Documentos/GrammaticalEvolution/data.txt' w p ls 1 title 'points'