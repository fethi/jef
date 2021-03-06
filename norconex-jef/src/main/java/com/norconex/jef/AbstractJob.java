/* Copyright 2010-2013 Norconex Inc.
 * 
 * This file is part of Norconex JEF.
 * 
 * Norconex JEF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Norconex JEF is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Norconex JEF. If not, see <http://www.gnu.org/licenses/>.
 */
package com.norconex.jef;

/**
 * Convenient base class for implementing jobs.  Provides a default
 * implementation of getId() passed at construction time.
 * @author Pascal Essiembre
 * @since 1.1
 */
public abstract class AbstractJob implements IJob {

    /** Job unique identifier. */
    private final String id;
    
    /**
     * Creates a new job.
     * @param id unique job identifier
     */
    public AbstractJob(String id) {
        super();
        this.id = id;
    }

    @Override
    public final String getId() {
        return id;
    }
}
