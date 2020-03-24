import numpy as np
import pandas as pd

# state name of file to use
FILENAME = 'test_SFLow_data.csv'

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

print("TOP 5 senders")
senders_grouped = df.groupby('src_IP').size().reset_index(name='Count')
senders_grouped = senders_grouped.sort_values(['Count'], ascending=False)
top5_senders = senders_grouped.head(5)
print(top5_senders)

print("TOP 5 listeners")
listeners_grouped = df.groupby('dst_IP').size().reset_index(name='Count')
listeners_grouped = listeners_grouped.sort_values(['Count'], ascending=False)
top5_listeners = listeners_grouped.head(5)
print(top5_listeners)

# EXERCISE 4B: TRANSPORT PROTOCOL 
print("Transport Protocol Percentage breakdown")
count_row = df.shape[0]
df_grouped = df.groupby('IP_protocol').size().reset_index(name='Count')
df_grouped = df_grouped.sort_values(['Count'], ascending=False)
df_grouped = df_grouped.loc[df_grouped['IP_protocol'].isin([6, 17])]
df_grouped['Percentage'] = df_grouped['Count'] / count_row * 100
top5 = df_grouped.head(5)
print(top5)

# EXERCISE 4C: APPLICATIONS PROTOCOL
print("Top 5 frequently used application protocol")
df_grouped = df.groupby('udp_dst_port/tcp_dst_port/icmp_code').size().reset_index(name='Count')
df_grouped = df_grouped.sort_values(['Count'], ascending=False)
top5 = df_grouped.head(5)
print(top5)

# EXERCISE 4D: TRAFFIC INTENSITY
print("Finding traffic intensity of the network")
count_row = df.shape[0]
df_packets = df
df_packets['Total_packet_size'] = df_packets['packet_size'] * df_packets['sampling_rate']
total_traffic = df_packets['Total_packet_size'].sum()
print("Total traffic: {}". format(total_traffic))


# Most communicated pairs
print("Finding most communicated pairs in the network")
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
