package org.apache.archiva.redback.users.ldap.ctl;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.archiva.redback.common.ldap.user.LdapUser;
import org.apache.archiva.redback.users.User;
import org.apache.archiva.redback.common.ldap.MappingException;
import org.apache.archiva.redback.users.ldap.LdapUserQuery;

import javax.naming.directory.DirContext;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 */
public interface LdapController
{

    void removeUser( String principal, DirContext context )
        throws LdapControllerException;

    void updateUser( User user, DirContext context )
        throws LdapControllerException, MappingException;

    boolean userExists( String key, DirContext context )
        throws LdapControllerException;

    Collection<User> getUsers( DirContext context )
        throws LdapControllerException, MappingException;

    void createUser( User user, DirContext context, boolean encodePasswordIfChanged )
        throws LdapControllerException, MappingException;

    LdapUser getUser( String key, DirContext context )
        throws LdapControllerException, MappingException;

    List<User> getUsersByQuery( LdapUserQuery query, DirContext context )
        throws LdapControllerException, MappingException;

    void initialize();

    /**
     * @param dirContext
     * @return Map key == username and value == list of role names
     * @throws LdapControllerException
     */
    Map<String, Collection<String>> findUsersWithRoles( DirContext dirContext )
        throws LdapControllerException;
}
