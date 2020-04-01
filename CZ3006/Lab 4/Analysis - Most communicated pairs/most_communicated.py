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

# Most communicated pairs
print("\nFinding most communicated pairs in the network")
df_new = df
df_new['IP_pair'] = None

for index, row in df_new.iterrows():
    IP_pair_list = []
    IP_pair_list.append(row['src_IP'])
    IP_pair_list.append(row['dst_IP'])
    IP_pair_list.sort()
    IP_pair_tuple = tuple(IP_pair_list)
    df_new.at[index, 'IP_pair'] = IP_pair_tuple

df_grouped = df.groupby('IP_pair').size().reset_index(name='Count')
df_grouped = df_grouped.sort_values(['Count'], ascending=False)
top5 = df_grouped.head(5)

print(top5)
