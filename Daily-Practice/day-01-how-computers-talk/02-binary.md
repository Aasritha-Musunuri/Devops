# Binary

## What is binary?

Binary is a way of writing numbers using only `0` and `1`. Decimal, which we use every day, uses the digits `0` to `9`.

The value is the same; only the way we write it changes.

```text
Decimal 5 = binary 101
```

Each binary position has a value. Reading from right to left, the values are 1, 2, 4, 8, and so on.

```text
Position value: 4  2  1
Binary digit:   1  0  1

4 + 0 + 1 = 5
```

## Why does this matter in DevOps?

Binary becomes useful when working with IP addresses and subnet masks. It explains how a network separates the part identifying the network from the part identifying a host.

## Example: an IPv4 address

A server might have this address:

```text
192.168.1.10
```

An IPv4 address contains four groups of eight bits, making 32 bits in total. Each group is shown as a decimal number from 0 to 255.

The last group, 10, can be written as:

```text
Position value: 128 64 32 16 8 4 2 1
Binary digit:    0   0  0  0 1 0 1 0

8 + 2 = 10
```

An eight-bit group filled with ones represents 255. This is why `192.168.1.300` is not a valid IPv4 address.

## A simple way to see it

In Windows PowerShell:

```powershell
ipconfig
```

Look for the IPv4 address and subnet mask of a connected adapter. An IPv4 address has four decimal groups. A mask such as `255.255.255.0` uses the first 24 bits to identify the network.

## What to remember

Binary is the number system underneath IPv4 addressing. Understanding the bit positions makes subnetting easier later.

## Reference

[Internet Protocol addressing - RFC 791](https://www.rfc-editor.org/rfc/rfc791.html)
