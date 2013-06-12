/**
 * Copyright (c) 2009-2013, rultor.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the rultor.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.rultor.queue;

import com.jcabi.aspects.Loggable;
import com.jcabi.urn.URN;
import com.rultor.users.Spec;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Work to do.
 *
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id$
 * @since 1.0
 */
public interface Work {

    /**
     * Unique ID of the work.
     * @return The ID
     */
    @NotNull
    String uid();

    /**
     * Owner of this work.
     * @return The owner
     */
    @NotNull
    URN owner();

    /**
     * Name of the work (unique for the user).
     * @return The name
     */
    @NotNull
    String name();

    /**
     * Spec to run.
     * @return The spec
     */
    @NotNull
    Spec spec();

    /**
     * Simple implementation.
     */
    @Loggable(Loggable.INFO)
    @ToString
    @EqualsAndHashCode(of = { "urn", "label", "desc" })
    final class Simple implements Work {
        /**
         * Owner of it.
         */
        private final transient URN urn;
        /**
         * Name of it.
         */
        private final transient String label;
        /**
         * Spec of it.
         */
        private final transient Spec desc;
        /**
         * Public ctor.
         * @param owner Owner
         * @param name Name
         * @param spec Spec
         */
        public Simple(@NotNull final URN owner, @NotNull final String name,
            @NotNull final Spec spec) {
            this.urn = owner;
            this.label = name;
            this.desc = spec;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public String uid() {
            throw new UnsupportedOperationException();
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public URN owner() {
            return this.urn;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public String name() {
            return this.label;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public Spec spec() {
            return this.desc;
        }
    }

}
