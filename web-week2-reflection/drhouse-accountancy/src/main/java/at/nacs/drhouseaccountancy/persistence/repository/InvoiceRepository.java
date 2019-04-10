package at.nacs.drhouseaccountancy.persistence.repository;

import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
