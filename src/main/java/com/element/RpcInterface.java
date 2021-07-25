package com.element;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface RpcInterface extends VersionedProtocol {
    long versionID = 1;
    int add(int n1, int n2);

    // homework
    String findName(int studentId);
}
