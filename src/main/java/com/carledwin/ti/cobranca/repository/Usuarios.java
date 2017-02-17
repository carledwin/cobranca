package com.carledwin.ti.cobranca.repository;

import com.carledwin.ti.cobranca.model.Usuario;

public interface Usuarios {

	Usuario findByLogin(String username);

}
