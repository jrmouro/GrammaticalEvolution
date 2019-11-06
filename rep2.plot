set title 'Test'
set xlabel 'time'
set ylabel 'volume'
set grid
set xrange [0:100]
set yrange [0:20]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = log(x**3) + sin(x)
g(x) = (((1.0**(((x - x) + (x / x)) - ((x / x) - (x / x)))) + ((1.0**(cos(x) * sin(x))) - (-1.0))) * log((x + (cos(x) - (x - x)))))
plot f(x) title 'log(x**3) + sin(x)', g(x) title '(((1.0**(((x - x) + (x / x)) - ((x / x) - (x / x)))) + ((1.0**(cos(x) * sin(x))) - (-1.0))) * log((x + (cos(x) - (x - x)))))'
