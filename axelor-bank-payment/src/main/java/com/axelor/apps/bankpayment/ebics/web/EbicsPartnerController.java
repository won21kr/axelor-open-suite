/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2017 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.bankpayment.ebics.web;

import com.axelor.apps.bankpayment.db.EbicsPartner;
import com.axelor.apps.bankpayment.db.repo.EbicsPartnerRepository;
import com.axelor.apps.bankpayment.ebics.service.EbicsPartnerService;
import com.axelor.exception.service.TraceBackService;
import com.axelor.i18n.I18n;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class EbicsPartnerController {
	
	@Inject
	EbicsPartnerService ebicsPartnerService;
	
	@Inject
	EbicsPartnerRepository ebicsPartnerRepository;
	
	public void getBankStatement(ActionRequest request, ActionResponse response )  {
		
		try {
			EbicsPartner ebicsPartner = request.getContext().asType(EbicsPartner.class);
		
			int statementNb = ebicsPartnerService.getBankStatements(ebicsPartnerRepository.find(ebicsPartner.getId()));
			response.setFlash(String.format(I18n.get("%s bank statements get."), statementNb));
		}
		catch(Exception e)  {
			TraceBackService.trace(response, e);
		}
		
	}
	
}
