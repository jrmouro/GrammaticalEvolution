set title 'Test'
set xlabel 'time'
set ylabel 'volume'
set grid
set xrange [0:100]
set yrange [0:20]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = log(x**3) + sin(x)
g(x) = log(((((x * x) * x) - ((x * x) + (x * x))) + (((-1.0) + sin(x)) / 1.0)))
plot f(x) title 'log(x**3) + sin(x)', g(x) title 'log(((((x * x) * x) - ((x * x) + (x * x))) + (((-1.0) + sin(x)) / 1.0)))'
