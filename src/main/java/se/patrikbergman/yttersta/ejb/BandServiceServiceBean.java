package se.patrikbergman.yttersta.ejb;

import se.patrikbergman.yttersta.entity.BandEntity;

import javax.ejb.*;

@Stateless
@Remote(CrudService.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class BandServiceServiceBean extends CrudServiceBean<BandEntity> {

}
