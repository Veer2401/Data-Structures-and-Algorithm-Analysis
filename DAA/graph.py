import matplotlib.pyplot as plt
import matplotlib.ticker as ticker

# Input sizes
n = [1, 10, 100, 1000, 10000, 100000]

# Execution times (nanoseconds)
bubble = [4200, 25100, 507200, 25551300, 2280039100, None]

selection = [7000, 22000, 293000, 20285000, 856843000, None]

insertion = [3000, 20000, 267000, 24793000, 831494000, None]

merge = [3000, 47000, 277000, 2316000, 23556000, 130439000]

quick = [35000, 20000, 94000, 1534000, 16262000, 83751000]

heap = [15000, 38000, 224000, 3113000, 33314000, 210014000]

# Create graph
plt.figure(figsize=(11, 7))

# Plot all algorithms
plt.plot(n, bubble, marker='o', linewidth=2, label='Bubble Sort')
plt.plot(n, insertion, marker='^', linewidth=2, label='Insertion Sort')
plt.plot(n, selection, marker='s', linewidth=2, label='Selection Sort')
plt.plot(n, merge, marker='D', linewidth=2, label='Merge Sort')
plt.plot(n, quick, marker='*', linewidth=2, label='Quick Sort')
plt.plot(n, heap, marker='x', linewidth=2, label='Heap Sort')

# Logarithmic scale
plt.xscale('log')
plt.yscale('log')

# Show actual values instead of 10^x
ax = plt.gca()

y_ticks = [
    1000,
    10000,
    100000,
    1000000,
    10000000,
    100000000,
    1000000000,
    10000000000
]

ax.set_yticks(y_ticks)
ax.yaxis.set_major_formatter(ticker.ScalarFormatter())
ax.yaxis.set_minor_formatter(ticker.NullFormatter())

# Labels
plt.xlabel("Input Size (n)", fontsize=12)
plt.ylabel("Execution Time (Nanoseconds)", fontsize=12)
plt.title("Comparison of Sorting Algorithms", fontsize=15, fontweight='bold')

# Grid
plt.grid(True, which='both', linestyle='--', alpha=0.6)

# Legend
plt.legend()

# Save high-quality graph
plt.savefig(
    "sorting_algorithms_comparison.png",
    dpi=300,
    bbox_inches="tight"
)

# Display graph
plt.show()

print("Graph saved successfully as 'sorting_algorithms_comparison.png'")