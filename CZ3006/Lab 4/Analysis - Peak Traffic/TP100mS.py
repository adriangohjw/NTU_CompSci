import numpy as np
import pandas as pd

# state name of file to use
FILENAME = 'SFlow_Data_lab4.csv'

# read from CSV file
matrix = np.genfromtxt(FILENAME, delimiter=',', dtype=None, encoding='utf-8')

# put data into a DataFrame + clean up + add headers
df = pd.DataFrame(data=matrix)
df = df.drop(df.columns[len(df.columns)-1], axis=1)
df.columns = [    
    "Type", "sflow_agent_address", "inputPort", "outputPort", "src_MAC", "dst_MAC",
    "ethernet_type", "in_vlan", "out_vlan", "src_IP", "dst_IP", "IP_protocol", "ip_tos", "ip_ttl", 
    "udp_src_port/tcp_src_port/icmp_type", "udp_dst_port/tcp_dst_port/icmp_code",
    "tcp_flags", "packet_size", "IP_size", "sampling_rate"
]
df.index.names = ['id']


"""
Measuring the average traffic per 100 millisecond (TP100mS) to determine peak network traffic

Assumptions:
- Data is collected over 15 seconds
- IP packets are evenly spread out and distributed over the 15 seconds
"""

import matplotlib.pyplot as plt

# create new DataFrame with the columns "timeframe" amd "total traffic" (in MB)
df_TP100mS = pd.DataFrame(columns = ['timeframe', 'total_traffic'])

# split dataframe into 150 equal portion
list_df = np.array_split(df, 150)
for i in range(len(list_df)):
    df_i = list_df[i]
    total_traffic = df_i['IP_size'].sum() * 1000 * 10**(-6)
    df_TP100mS.loc[len(df_TP100mS)] = [i/10, total_traffic]

# find peak traffic by sorting dataframe
peak_traffic = df_TP100mS['total_traffic'].max()
print("Peak traffic: {} MB".format(peak_traffic))

# find average (median) traffic
average_traffic = df_TP100mS['total_traffic'].median()
print("Average traffic: {} MB".format(average_traffic))

# plot and display results in a graph
ax = plt.gca()
df_TP100mS.plot(kind='line', x='timeframe', y='total_traffic', ax=ax)
plt.show()
