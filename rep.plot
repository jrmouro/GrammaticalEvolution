set title 'Test'
set xlabel 'time'
set ylabel 'volume'
set grid
set xrange [0:100]
set yrange [0:20]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = (((1.0**(((x - x) + (x / x)) - ((x / x) - (x / x)))) + ((1.0**(cos(x) * sin(x))) - (-1.0))) * log((x + (cos(x) - (x - x)))))
plot f(x) title '(((1.0**(((x - x) + (x / x)) - ((x / x) - (x / x)))) + ((1.0**(cos(x) * sin(x))) - (-1.0))) * log((x + (cos(x) - (x - x)))))', '/home/ronaldo/Documentos/GrammaticalEvolution/data.txt' w p ls 1 title 'points'