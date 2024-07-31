package by.zeus.demo.login.admin.service;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.login.admin.domain.AdminEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BaseService<AdminEntity> {
    public AdminService(final BaseRepository<AdminEntity> repository) {
        super(repository);
    }
}
