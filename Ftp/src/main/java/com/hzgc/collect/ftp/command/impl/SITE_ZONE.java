/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.hzgc.collect.ftp.command.impl;

import com.hzgc.collect.ftp.command.AbstractCommand;
import com.hzgc.collect.ftp.ftplet.DefaultFtpReply;
import com.hzgc.collect.ftp.ftplet.FtpException;
import com.hzgc.collect.ftp.ftplet.FtpReply;
import com.hzgc.collect.ftp.ftplet.FtpRequest;
import com.hzgc.collect.ftp.impl.FtpIoSession;
import com.hzgc.collect.ftp.impl.FtpServerContext;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <strong>Internal class, do not use directly.</strong>
 * 
 * Displays the FTP server timezone in RFC 822 format.
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class SITE_ZONE extends AbstractCommand {

    private final static SimpleDateFormat TIMEZONE_FMT = new SimpleDateFormat(
            "Z");

    /**
     * Execute command.
     */
    public void execute(final FtpIoSession session,
                        final FtpServerContext context, final FtpRequest request)
            throws IOException, FtpException {

        // reset state variables
        session.resetState();

        // send timezone data
        String timezone = TIMEZONE_FMT.format(new Date());
        session.write(new DefaultFtpReply(FtpReply.REPLY_200_COMMAND_OKAY,
                timezone));
    }
}
