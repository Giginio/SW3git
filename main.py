import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# Create a DataFrame with random numbers
data = {'A': np.random.rand(50) + 1,
        'B': np.random.rand(50) + 1}

df = pd.DataFrame(data)

# Plot the DataFrame
plt.figure(figsize=(10, 6))
plt.scatter(df['A'], df['B'])
plt.title('Scatter Plot of Random Numbers')
plt.xlabel('A')
plt.ylabel('B')
plt.grid(True)
plt.show()